package cmap.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// --- Sử dụng giao thức RestFul service chỉ trả về body dưới dạng json
@RestController
// --- Url mặc định cho controller này xiziu.com/data/{action}
@RequestMapping(value = "/test", consumes = MediaType.ALL_VALUE, headers="Accept=application/json")
public class AssignController {
	@RequestMapping(method = RequestMethod.POST)
	public String test(@RequestBody String name){
		System.out.println("THành công ! " + name);
		return name;
	}
}
