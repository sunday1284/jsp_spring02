package kr.or.ddit.case10;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileUploadVO {
	@NotBlank
	private String uploader;
	@NotNull
	private MultipartFile uploadFile;
	
	//업로드 파일이 있는지 없는지 검증 -> 비어있는 파트 검증
	public void setUploadFile(MultipartFile uploadFile) {
		if(uploadFile!=null && !uploadFile.isEmpty()) {
			this.uploadFile = uploadFile;
		}
	}
}
