package kr.or.ddit.case10.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.case10.FileUploadVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case10/upload")
public class FileUploadController {
	 
	
//	@Value("file:D:/00.medias/saveFiles/")
	@Value("#{fileInfo['saveFolder']}")
	Resource saveFolderRes;
	
	File saveFolder;
	
	//folder에 있는 파일 객체 미리 생성
	@PostConstruct
	public void init() throws IOException {
		saveFolder =  saveFolderRes.getFile();
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
	}
	
	@GetMapping
	public void formUI() {
		
		
	}
	
	
	//multiPart 파일을 받아오는법
	@PostMapping
	public String fileUpload2(
		@Valid @ModelAttribute("commandObject") FileUploadVO commandObject
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) throws IOException {
		//통과 시 
		if(!errors.hasErrors()) {
			log.info("uploader : {}",commandObject.getUploader());
			MultipartFile uploadFile = commandObject.getUploadFile();
			log.info("uploadFile : {}",uploadFile);
			//파일 업로드 처리 과정
			String saveName = UUID.randomUUID().toString();
			File saveFile = new File(saveFolder, saveName);
			//최종업로드 처리 
			uploadFile.transferTo(saveFile);
			log.info("upload path : {}", saveFile.toPath());
			redirectAttributes.addFlashAttribute("saveName", saveName);
			return "redirect:/case10/files";
		}else {
			log.info("검증 통과 못함, 에러 갯수 : {}", errors.getErrorCount());
			redirectAttributes.addFlashAttribute("commandObject", commandObject);
			redirectAttributes.addFlashAttribute("errors", errors);
			return "redirect:/case10/upload";
		}
		
	}
	
	public String fileUpload1(
			@RequestParam("uploader") String uploader
			, @RequestPart("uploadFile") MultipartFile  uploadFile
			
			) throws IOException {
		
//		if(uploadFile.isEmpty())
		
		log.info("uploader : {}",uploader);
		log.info("uploadFile : {}",uploadFile);
		//파일 업로드 처리 과정
		String saveName = UUID.randomUUID().toString();
		File saveFile = new File(saveFolder, saveName);
		//최종업로드 처리 
		uploadFile.transferTo(saveFile);
		log.info("upload path : {}", saveFile.toPath());
		return null;
	}
}
