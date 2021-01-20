package daily.game.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import daily.game.dao.BoardAttachDAO;
import daily.game.dto.BoardAttachDTO;


@Controller
@RequestMapping("/upload")
public class UploadController {
	private static final Logger Logger= LoggerFactory.getLogger(UploadController.class);
	@Autowired
	BoardAttachDAO battachdao;//?????
	
	//현재 날짜를 구하는 method
	private String getFolder() {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");//Date형태 객체
		//현재날짜
		Date date= new Date(); //Date객체. 비워두면 현재 날짜.
		String str=sdf.format(date);//심플 데이터 포멧에 date객체의 현재날짜를 자동적으로 적용.
	//'-'문자열을 'w'로 치환해야 한다.(replace)
		return	str.replace("-",File.separator);//파일,폴더의 구분자.(w\원표시)로바꿔준다.
	}
	
	
	
	
	@PostMapping("/uploadFormAction")	 //객체 이름과  input의 name을 맞춰준다.
	public ResponseEntity<ArrayList<BoardAttachDTO>>postUpload(MultipartFile[] uploadFile) {
		//AttachFileDTO클래스를 list 배열로 생성
		ArrayList<BoardAttachDTO> list = new ArrayList<>();
		//어떤 폴더게 실재로 업로드를 할 것인지에 대한 폴더 경로
		String uploadFolder="D:\\uploadFolder";
		String uploadFolderPath=getFolder();
		//날짜별 폴더 생성.
		//File 변수명= new File(파일 업로드 경로, 파일명);
		File uploadPath= new File (uploadFolder, uploadFolderPath);
		
		//똑같은 폴더명을 만들 필요가 없기 때문에 exists() 함수를 통해 존재여부를 파악. 없으면(false) 폴더를 생성하라.
		if(uploadPath.exists()==false) {
			uploadPath.mkdirs();//폴더를 make해라.
		}
		System.out.println("file="+uploadFile.length);
		//향상된 for(타입이 배열 타입일 때만 사용)
		for(MultipartFile files: uploadFile) {
			Logger.info("파일명="+files.getOriginalFilename());
			Logger.info("파일크기="+files.getSize());
			BoardAttachDTO attach = new BoardAttachDTO();
			String uploadFileName=files.getOriginalFilename();
			//BoardAttachDTO 클래스에 Filename변수에 파일이름저장.
			attach.setFileName(uploadFileName);
			
			//uuid클래스를 이용하여 중복되지 않느 ㄴ랜덤값을 생성.
			UUID uuid = UUID.randomUUID();
			Logger.info("uuid="+uuid);
			uploadFileName=uuid.toString()+"_"+files.getOriginalFilename();
			try {
				File saveFile= new File(uploadPath,uploadFileName);
				Logger.info("saveFile"+saveFile);
				files.transferTo(saveFile);
				attach.setUploadPath(uploadFolderPath);
				attach.setUuid(uuid.toString());
				list.add(attach);
				Logger.info("list="+list);
			}catch(Exception e) {
				e.getMessage();
			}
		}//향상된 for문 END
		return new ResponseEntity<>(list,HttpStatus.OK);
	}//uploadFormAction post END
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]>getFiles(String fileName){
		System.out.println(fileName);
		File file= new File("D:\\uploadFolder\\"+fileName);
		ResponseEntity<byte[]> result= null;
		try {
			HttpHeaders header= new HttpHeaders();
			header.add("Content-type",Files.probeContentType(file.toPath()));
			result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),
					header,HttpStatus.OK);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
}