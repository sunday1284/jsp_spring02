package kr.or.ddit.case10.mission;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;

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

/**
 * 
 */
@Controller
@RequestMapping("/case10/mission/files/")
public class ImageFileDownloadController {
	private Path folderPath;

	@Value("#{fileInfo.imageFolder}")
	private Resource folderRes;

	@GetMapping("{filename}")
	public ResponseEntity<Resource> download(@PathVariable("filename") String filename) throws IOException {
//	
//		4. folderPath 와 파일명에 해당하는 target 파라미터의 값으로 filePath 생성 
		Resource file = folderRes.createRelative(filename);
//		5. filePath에 해당하는 파일이 없거나, 실제 파일이 맞는지 검증, 검증 통과하지 못한 경우, 400에러 전송.
		if (!file.exists() || !file.isFile()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "해당 파일 없음");
		}
		HttpHeaders headers = new HttpHeaders();
		ContentDisposition cd = ContentDisposition.attachment()
								.filename(filename, Charset.forName("UTF-8"))
								.build();
		headers.setContentDisposition(cd);
		headers.setContentLength(file.contentLength());
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return ResponseEntity.ok().headers(headers).body(file);
	}
}
