package com.kh.java.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

// FileRenamePolicy 라는 인터페이스를 구현해서
// 이름 바꾸기 정책을 사용
public class MyRenamePolicy  implements FileRenamePolicy {
	// FileRenamePolicy 인터페이스가 가지고 있는 rename 추상메소드가 있음
	// rename메소드를 오버라이딩해서 기존 파일명을 전달받아서 파일명을 수정한 뒤 
	// 수정한 파일을 반환해줄 것 
	public File rename(File originFile) {
		
		// "aaa.jpg"
		// "bbb.jpg"
		// "ccc.jpg"
		
		// 원본파일명
		String originName = originFile.getName();
		
		// 우리 입맛대로 이름 바꾸기 => 최대한 이름이 안겹치도록
		// KHacademy_년월시분초_랜덤값 + 원본 파일 확장자
		
		/*
		 * 예시)
		 * 원본파일명			바꾸기
		 * bono.jpg	 => 	KHacademy_20250930163122_999.jpg
		 * 
		 */
		
		// 1. 원본파일의 확장자 // 예외 처리 필요
		String ext = originName.substring(originName.lastIndexOf("."));
		
		// 2. 년월시분초
		String currentTime = new SimpleDateFormat("yyyMMddHHmmss").format(new Date());
		
		// 3. 랜덤숫자
		int randomNo = (int)(Math.random() * 900) + 100;
		
		// 1 + 2 + 3
		String changeName = "KHacademy_" + currentTime + "_" + randomNo + ext;
		
		/*
		 
		// 문자열 뒤집기
		 
		String str = "abc";
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.reverse(); // cba
		
		또는
		
		String str = "abc";
		String reversed = "";
		
		for (int i = str.length() - 1; i >= 0; i--) {
		    reversed += str.charAt(i);
		}
		
		*/
		
		// 100% 안 겹치게 하려면? 락(lock) 걸기, 멀티스레드 안전한 클래스 사용, UUID 사용 (가장 보편)
		
		// 기존 파일명을 수정된 파일명으로 적용시켜서 반환
		return new File(originFile.getParent(), changeName);
	}
	
}
