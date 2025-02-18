package kr.or.ddit.case10.mission;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.case10.FileUploadVO;

//dispatcher Controller 가 multipart 처리
@Controller
@RequestMapping("/case10/mission/files/upload")
public class ImageFileUploadController{
	
	@Value("#{fileInfo.imageFolder}")
	Resource saveFolderRes;
	//따로 init 메소드 생성 안해도 된다.
	@Value("#{fileInfo.imageFolder}")
	File saveFolder;
	
	
	
	
	
	@GetMapping
	public String FormUI() {
		return "case10/mission/fileUpload";
	}
	
	@PostMapping
	public String UploadProcess(
	   @RequestPart("uploadFile") MultipartFile uploadFile
	   , RedirectAttributes redirectAttributes
	) throws IllegalStateException, IOException{
//		2. empty part 체크 
		if(uploadFile.isEmpty()) {
//		3. empty part ? 400 전송 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"필수 파일 누락");
		}
		
		if(!uploadFile.getContentType().startsWith("image/")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"이미지 이외 업로드 불가.");
		}
		
//		4. not empty part ? -> part데이터가 있을때
//		6. savename 생성 
		String savename = UUID.randomUUID().toString();
//		7. filePath 생성 
		File saveFile = new File(saveFolder, savename);
		
//		8. transferTo 에 저장(stream copy)
		uploadFile.transferTo(saveFile);
		//
		redirectAttributes.addFlashAttribute("uploaded", saveFile.toPath());
		
		return "redirect:/case10/mission/files";
		
	}
}
