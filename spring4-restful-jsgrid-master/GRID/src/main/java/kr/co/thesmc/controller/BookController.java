package kr.co.thesmc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.thesmc.model.Book;
import kr.co.thesmc.model.JsonResult;
import kr.co.thesmc.service.BookService;

@Controller
public class BookController {

	@Autowired
    BookService bookService;
	
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) throws Exception {
    	return "book/home";
    }
    
    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public String home2(Model model) throws Exception {
    	return "book/home2";
    }    

    @RequestMapping(value = "/home3", method = RequestMethod.GET)
    public String home3(Model model) throws Exception {
    	return "book/home3";
    }
    
    @RequestMapping(value = "/home4", method = RequestMethod.GET)
    public String home4(Model model) throws Exception {
    	return "book/home4";
    }
    
    
	@SuppressWarnings("finally")
	@ResponseBody
    @RequestMapping(value = "/api", produces = "application/json", method=RequestMethod.GET)
    public Object list(Model model, @RequestParam Map<String , String> filter) throws Exception {
		
		JsonResult result =  new JsonResult();
		
		try{
			result.setStatus("ok");
			result.setData(bookService.getBookList(filter));
		}catch(Exception e){
			    e.printStackTrace();
		}finally{
			return result;
		}
		
    }

	@SuppressWarnings("finally")
	@ResponseBody
    @RequestMapping(value = "/api", produces = "application/json", method=RequestMethod.POST)
    public Object insert(Model model, @RequestBody Book vo) throws Exception {
		JsonResult result =  new JsonResult();
		
		try{
			bookService.getBookInsert(vo);
			result.setStatus("ok");
		}catch(Exception e){
			    e.printStackTrace();
		}finally{
			return result;
		}
    }
	
	@SuppressWarnings("finally")
	@ResponseBody
    @RequestMapping(value = "/api/{id}", produces = "application/json", method=RequestMethod.PUT)
    public Object update(Model model, @PathVariable String id, @RequestBody Book vo) throws Exception {
		JsonResult result =  new JsonResult();
		
		try{
			bookService.getBookUpdate(vo);
			result.setStatus("ok");
		}catch(Exception e){
			    e.printStackTrace();
		}finally{
			return result;
		}
    }

	@SuppressWarnings("finally")
	@ResponseBody
    @RequestMapping(value = "/api/{id}", produces = "application/json", method=RequestMethod.DELETE)
    public Object delete(Model model, @PathVariable String id) throws Exception {
		JsonResult result =  new JsonResult();
		
		try{
			bookService.getBookDelete(id);
			result.setStatus("ok");
		}catch(Exception e){
			    e.printStackTrace();
		}finally{
			return result;
		}
    }
	
}
