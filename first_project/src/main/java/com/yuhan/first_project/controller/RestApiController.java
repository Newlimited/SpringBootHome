package com.yuhan.first_project.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.yuhan.first_project.dto.request.ExampleDto;
import com.yuhan.first_project.dto.response.ExampleResponseDto;
import com.yuhan.first_project.service.implement.RestApiService;
import com.yuhan.first_project.service.implement.RestApiServiceImplement;

import ch.qos.logback.core.status.Status;

class ParamDto {
     String data1;
     String data2;

    public String getData1() {
        return this.data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return this.data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

}
// Rest API를 위한 Controller 임을 명시해주는 어노테이션 
// @Controller + @Response Body = @RestController
// Response는 HTML을 제외한 MIME Type을 반환한다.
@RestController
// URL path 패턴을 지정해서 해당 패턴이면 지정한 클래스로 처리하도록 함
@RequestMapping(value = "api")
public class RestApiController {

    // private RestApiServiceImplement restApiServiceImplement = 
    // new RestApiServiceImplement(); // 의존성을 직접 만들고있음 
    // Service 에서 하나만 오류가 뜨면 그것만 떠야하는데 이렇게 되어있으면
    // 하나가 오류나면 전체를 이용하지 못한다. 그래서 Spring IOC를 이용해서 주입해볼것이다.
    // 그러기 위해선 bean 에 등록해야한다. 방법은 @component 하면된다 (or @Service)
   
    // private RestApiServiceImplement restApiService; // spring이 알아서 불러온다 
    public RestApiService restApiService;

    public RestApiController(RestApiService restApiService){
        this.restApiService = restApiService;
    }

    @RequestMapping(method = { RequestMethod.GET }, value = "hello2")
    public String hello2() {
        return "hello2";
    }

    // GET Method @GetMapping
    // GET Method : 클라이언트가 서버에게 데이터를 받기 위한 요청의 Method
    // @RequesetMaaping(method = RequestMethod.GET, value = "get-method")
    @GetMapping("get-method")
    public String getMethod(
        @AuthenticationPrincipal String subject
    ) {
       return subject;
    }

    // POST Method @PostMapping
    // Post Method : 클라이언트가 서버에 데이터를 작성하기 위한 요청의 Method
    // @RequestMapping (method = RequestMethod.POST, value =" post-method")
    @PostMapping("post-method")
    public String postMethod() {

        return restApiService.postMethod();
    }

    // Patch Method @PatchMapping
    // Patch Method : 클라이언트가 서버에 데이터를 일부만 수정하기 위한 요청의 Method
    @PatchMapping("patch-method")
    public String patchMethod() {
        return restApiService.patchMethod();
    }

    // Delete Method @DeleteMapping
    // Delete Method : 클라이언트가 서버에 데이터를 삭제하기 위한 요청의 Method
    @DeleteMapping("delete-method")
    public String deleteMethod() {
        return restApiService.deleteMethod();
    }

    // PathVariable() 로 Get, Delete Method에서 데이터 받기
    // 리소스에 지정한 패턴에 맞춰서 요청의 URL을 지정한다면 패턴에 맞춰 데이터를 받아오는 형식
    @GetMapping({ "path-variable/{data1}/{data2}", "path-variable/{data1}" })
    public String pathVariable(
            @PathVariable(value = "data1") String dataA,
            @PathVariable(value = "data2", required = false) String dataB
    // 이것의 입장으로는 입력을 받는것이기 때문에 parameter 자리에 적어준다.
    ) {
        return dataA + "와" + dataB + "데이터를 입력 받았습니다.";
    }

    // @RequestParam 로 GET, Delete MEthod에서 데이터 받기
    // 완전 path 뒤에 ?name=value[&...] 형식에 맞춰 name에 해당하는 value를 받아오는 형식
    @GetMapping("request-param")
    public String requestParam( // ParamDto dto)
            // path까지만 작성하고 뒤에 따로 받아오는 형태이다
            // (물음표)? 이후부터는 데이터의 포맷으로 인식한다.
            @RequestParam String data1,
            @RequestParam String data2

    ) {
        // return dto.getData1() + dto.getData2() + "데이터를 입력 받았습니다.";
        return data1 + data2 + "데이터를 입력 받았습니다.";
    }

    // @RequestBody 로 Post, Put, Patch Method 에서 데이터 받기
    // Request Body에 있는 데이터를 받기 위한 어노테이션
    @PostMapping("request-body")
    public ResponseEntity<ParamDto> requestBody(
           // @RequestBody String data 문자열로 받을 적엔 이렇게 ..
    // 기본적으로 true 가 박혀있고 required 형태로... 반환
    @RequestBody ParamDto dto
    ) {
        return ResponseEntity.status(408).body(dto);
                // return dto.getData1() + dto.getData2() +"데이터를 받았습니다.";
        // return data + "데이터를 받았습니다.";
    }
    @PostMapping("lombok")
    public ResponseEntity<ExampleResponseDto> lombok(
            @Valid @RequestBody ExampleDto requestBody
        ){
            String data1 = requestBody.getParameter1();
            String data2 = requestBody.getParameter2();
            String data3 = requestBody.getParameter3();

            // ExampleResponseDto responseDate = 
            // new ExampleResponseDto(data1, data2, data3);

            ExampleResponseDto responseData = 
                ExampleResponseDto.builder().data1(data1).build();

           System.out.println(responseData.toString());

            return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(responseData);
    }
}