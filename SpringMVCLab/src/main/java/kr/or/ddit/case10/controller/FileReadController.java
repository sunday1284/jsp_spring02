package kr.or.ddit.case10.controller;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/case10")
public class FileReadController {
	
	@Value("/resources/files/")
	Resource saveFolderRes;
	
	@GetMapping("files")
	public void readUI() {
		
	}
	@GetMapping("download/{filename}")
	public ResponseEntity<Resource> download(
		@PathVariable("filename") String filename
	) throws IOException {
		Resource file = saveFolderRes.createRelative(filename);
		if(!file.exists()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 파일이 없음.");
		}
		
		// response body를 200으로 설정함
		HttpHeaders headers = new HttpHeaders();
		//1.  Content-Disposition:attatchment;filename="파일명" ->라인
		ContentDisposition cd = ContentDisposition.attachment()
								.filename(filename, Charset.defaultCharset()) //기본으로 UTF-8설정
								.build();
		headers.setContentDisposition(cd);
		
//		2.  Content-Length -> 헤더
		headers.setContentLength(file.contentLength());
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//		//다운로드에 필요한 응답 헤더 

//		3.  Content-Type -> BODY
		return ResponseEntity.ok() // response line
			.headers(headers) // response header
			.body(file); // response body
		
	}
	
}
