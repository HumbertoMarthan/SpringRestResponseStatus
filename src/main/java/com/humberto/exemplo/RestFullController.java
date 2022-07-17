package com.humberto.exemplo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Controller
public class RestFullController {

	 public ResponseEntity<?> codeResponse(Map<String,Object> body, int code) {
		  
		  switch (code) {
				case 200: {
					return new ResponseEntity<Object>(body, HttpStatus.OK);
				}
				case 201: {
					return new ResponseEntity<Object>(body, HttpStatus.CREATED);		
				}
				case 204: {
					return new ResponseEntity<Object>(body, HttpStatus.NO_CONTENT);
				}
				case 400: {
					return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
				}
				case 401: {
					return new ResponseEntity<Object>(body, HttpStatus.UNAUTHORIZED);
				}
				case 500: {
					return new ResponseEntity<Object>(body, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		  
		  	return null;
	  }	
	
	  @PostMapping("/postResponseStatus201")
	  public @ResponseBody ResponseEntity<?> postResponseStatus201(@RequestHeader(value = "Authorization") String token,
			  													  @RequestBody Map<String,Object> body){ 
		 
		  Map<String,Object> retorno = new HashMap<>();
		 
		  try {
			  
				  if(token == null || !validarToken(token)) {
					  retorno.put("success",false);
					  retorno.put("message","Token Inválido");
					  return codeResponse (retorno ,401);
				  }
			  
				  retorno.put("success",true);
			  	  retorno.put("message","Requisição Show");
			  	  return codeResponse (retorno ,201);

		  } catch (Exception e) {
			  e.printStackTrace();
			  //situacao erro interno ao processar algo
			  retorno.put("success",false);
			  retorno.put("message", e.getMessage());
			  return codeResponse (retorno ,500);
		  }
	  }
	  
	  @PostMapping("/postResponseStatus204")
	  public @ResponseBody ResponseEntity<?> postResponseStatus204(@RequestHeader(value = "Authorization") String token,
			  													  @RequestBody Map<String,Object> body){ 
		 
		  Map<String,Object> retorno = new HashMap<>();
		 
		  try {
			  
				  if(token == null || !validarToken(token)) {
					  retorno.put("success",false);
					  retorno.put("message","Token Inválido");
					  return codeResponse (retorno ,401);
				  }
				  return codeResponse (retorno ,204);

		  } catch (Exception e) {
			  e.printStackTrace();
			  //situacao erro interno ao processar algo
			  retorno.put("success",false);
			  retorno.put("message", e.getMessage());
			  return codeResponse (retorno ,500);
		  }
	  }
	  	
	
	  @GetMapping("/getResponseStatus200")
	  public @ResponseBody ResponseEntity<?> getResponseStatus200(@RequestHeader(value = "Authorization") String token){ 
		 
		  Map<String,Object> retorno = new HashMap<>();
		 
		  try {
			  
				  if(token == null || !validarToken(token)) {
					  retorno.put("success",false);
					  retorno.put("message","Token Inválido");
					  return codeResponse (retorno ,401);
				  }
			  
			  	  //situacao de OK em operações GET
				  retorno.put("success",true);
			  	  retorno.put("message","Requisição Show");
			  	 return codeResponse (retorno ,200);

		  } catch (Exception e) {
			  e.printStackTrace();
			  //situacao erro interno ao processar algo
			  retorno.put("success",false);
			  retorno.put("message", e.getMessage());
			  return codeResponse (retorno ,500);
		  }
	  }
	  
	  @GetMapping("/getResponseStatus401")
	  public @ResponseBody ResponseEntity<?> getResponseStatus401(@RequestHeader(value = "Authorization") String token){ 
		 
		  Map<String,Object> retorno = new HashMap<>();
		 
		  if(token == null || !validarToken(token)) {
			  retorno.put("success",false);
			  retorno.put("message","Token Inválido");
			  return codeResponse (retorno ,401);
		  }
		  
		  return null;
	  }
	  
	  @GetMapping("/getResponseStatus400")
	  public @ResponseBody ResponseEntity<?> getResponseStatus400(@RequestHeader(value = "Authorization") String token){ 
		 
		  Map<String,Object> retorno = new HashMap<>();
		 
		  try {
			  
				  if(token == null || !validarToken(token)) {
					  retorno.put("success",false);
					  retorno.put("message","Token Inválido");
					  return codeResponse (retorno ,401);
				  }
			  
				  //situacao de requisicao invalida
			  	  retorno.put("success",false);
			  	  retorno.put("message","Erro na Requisição Inválida");
			  	 return codeResponse (retorno ,400);
					  
				  
		  } catch (Exception e) {
			  e.printStackTrace();
			  //situacao erro interno ao processar algo
			  retorno.put("success",false);
			  retorno.put("message", e.getMessage());
			  return codeResponse (retorno ,500);
		  }
	  }
	  
	  @GetMapping("/getResponseStatus500")
	  public @ResponseBody ResponseEntity<?> getResponseStatus500(@RequestHeader(value = "Authorization") String token){ 
		 
		  Map<String,Object> retorno = new HashMap<>();
		 
		  try {
			  
				  if(token == null || !validarToken(token)) {
					  retorno.put("success",false);
					  retorno.put("message","Token Inválido");
					  return codeResponse (retorno ,401);
				  }
			  
				  List<String> lst = new ArrayList<>();
				  lst.get(0);
				  
		  } catch (Exception e) {
			  //situacao erro interno ao processar algo
			  retorno.put("success",false);
			  retorno.put("message", e.getMessage());
			  return codeResponse (retorno ,500);
		  }
		
		  return null;
	  }
	  
	  
	  public boolean validarToken(String token) {
		  if(token.equals("1234")) {
			  return true;
		  }else {
			  return false;
		  }
	  }
	  
}