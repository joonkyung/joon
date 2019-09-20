package kr.co.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {

	public static void setContent(HttpHeaders headers, String filename) throws Exception {
		String formatName = filename.substring(filename.lastIndexOf(".")+1);
		if(formatName.equalsIgnoreCase("png")){
			headers.setContentType(MediaType.IMAGE_PNG);	
		}else if (formatName.equalsIgnoreCase("jpg")) {
			headers.setContentType(MediaType.IMAGE_JPEG);
		}else if (formatName.equalsIgnoreCase("jpeg")) {
			headers.setContentType(MediaType.IMAGE_JPEG);
		}else if (formatName.equalsIgnoreCase("gif")) {
			headers.setContentType(MediaType.IMAGE_GIF);
		}else {
			filename = filename.substring(filename.indexOf("_")+1);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Dispositon", "attachment;filename=\""+new String(filename.getBytes("UTF-8")+"\""));
			
		}
	}


	public static String makeIcon(String uploadPath, String datePath, String savedName) throws Exception {

		File file = new File(uploadPath + datePath, savedName);

		BufferedImage sourceImg = ImageIO.read(file);
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, // 자동으로 크기를 맞춰주어라
				Scalr.Mode.FIT_EXACT, 100); // 가로 세로를 100으로 맞추어라

		String thumbnailName = uploadPath + datePath + File.separator + "s_" + savedName;

		String formatName = savedName.substring(savedName.lastIndexOf('.') + 1);
		File newFile = new File(thumbnailName);

		ImageIO.write(destImg, formatName.toUpperCase(), newFile);

		String bp = thumbnailName.substring(uploadPath.length());
		String bp_suffix = thumbnailName.substring(bp.lastIndexOf(".")+1);
		bp = bp.replace(bp_suffix, bp_suffix.toLowerCase());
		
		String ap = bp.replace(File.separatorChar, '/');

		return ap;
	}

	public static String uploadFile(String uploadPath, MultipartFile file) throws Exception {
		String ori_name = file.getOriginalFilename();
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + ori_name; // 실제로 관리되는 파일명.
		String datePath = calPath(uploadPath); // 날짜 폴더에대한 정보, 반환형 datePath
		File target = new File(uploadPath + datePath, savedName);
		if (ori_name == null || ori_name.equals("")) {
			return "";
		}
		FileCopyUtils.copy(file.getBytes(), target);

		String formatName = ori_name.substring(ori_name.lastIndexOf('.') + 1);

		String ap = "";
		if (checkFormat(formatName)) {
			// 썸네일 제작. 이미지 파일에 대해서만 썸네일 작성
			ap = makeIcon(uploadPath, datePath, savedName);

		} else {
			String bp = datePath + File.separator + savedName;
			ap = bp.replace(File.separatorChar, '/'); // 구분자 변경
		}

		return ap;
	}

	private static boolean checkFormat(String formatName) {
		List<String> list = new ArrayList<String>();
		list.add("jpg");
		list.add("jpeg");
		list.add("png");
		list.add("gif");
		list.add("jpg".toUpperCase());
		list.add("jpeg".toUpperCase());
		list.add("png".toUpperCase());
		list.add("gif".toUpperCase());

		return list.contains(formatName);
	}

	public static String calPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format((cal.get(Calendar.MONTH) + 1));
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, datePath);

		return datePath;
	}

	public static void makeDir(String uploadPath, String... arr) {// 가변인자 varargs

		if (new File(uploadPath + arr[arr.length - 1]).exists()) {
			return;
		}

		for (String path : arr) {
			File dirPath = new File(uploadPath + path);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}

	}

	public static ResponseEntity<byte[]> displayfile(String uploadPath, String filename) {
		ResponseEntity<byte[]> entity = null;

		InputStream in = null;

		try {
			in = new FileInputStream(uploadPath + filename);
			HttpHeaders headers = new HttpHeaders();

			setContent(headers, filename);

			headers.setContentType(MediaType.IMAGE_JPEG);
			headers.setContentType(MediaType.IMAGE_PNG);
			headers.setContentType(MediaType.IMAGE_GIF);

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return entity;
	}

}