package kr.or.ddit.case10.mission;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ImageFileDeleteController {
	
	@Value("#{fileInfo.imageFolder}")
	Resource saveFolderRes;
	@Value("#{fileInfo.imageFolder}")
	File saveFolder;
	
	//요청이 json 이면
	@DeleteMapping(value="/case10/mission/files/{filename}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(
		@PathVariable("filename") String filename
		, Model model
	) throws IOException{

//		4. folderPath 와 파일명에 해당하는 target 파라미터의 값으로 filePath 생성 
//		Resource targetFile = saveFolderRes.createRelative(filename);
		File targetFile = new File(saveFolder, filename);
		Path filePath = targetFile.toPath();
		
//		5. filePath에 해당하는 파일이 없거나, 실제 파일이 맞는지 검증, 검증 통과하지 못한 경우, 400에러 전송.
		if(!Files.exists(filePath) || Files.isDirectory(filePath)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		//6. 파일 삭제 
		Files.delete(filePath);	
		
		model.addAttribute("success", true);
		model.addAttribute("targetFile", filePath.getFileName().toString());
	}
}
