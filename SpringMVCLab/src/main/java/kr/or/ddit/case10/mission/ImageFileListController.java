package kr.or.ddit.case10.mission;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

//마커 서블릿, loadOnStartup -> 서버 구동하면 바로 실행
@Slf4j
@Controller
@RequestMapping("/case10/mission")
public class ImageFileListController{
   
   private Path folderPath;
   
   @Value("#{fileInfo.imageFolder}")
   private Resource folderRes;
      
   @PostConstruct
   public void init() throws IOException {
      folderPath =  folderRes.getFile().toPath();
      log.info("{} 객체 생성 및 초기화 완료", this.getClass().getSimpleName());
   }
   
   @GetMapping(value="files")
   public String listUI(Model model) throws IOException {
      List<Path> fileList = new ArrayList<>();
      Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() {
         @Override
         public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            fileList.add(file);
            return super.visitFile(file, attrs);
         }
      });
      
      // scope에 attribute로 저장.
      // request dispatch로 이동하는 경우 : request scope활용
      // redirect로 이동하는 경우 : session scope활용
      
      model.addAttribute("fileList", fileList);
      return "tiles:case10/mission/fileList";
      
   }
}
