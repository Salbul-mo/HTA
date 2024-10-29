package net.board.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;

public class BoardFileDownAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("filename");
		System.out.println("filename = " + fileName);
		
		String savePath = "boardupload";
		
		// 서블릿의 실행 환경 정보를 담고 있는 객체를 리턴한다.
		ServletContext context = request.getServletContext();
		String sDownloadPath = context.getRealPath(savePath);
		
		String sFilePath = sDownloadPath + File.separator + fileName;
		
		System.out.println(sFilePath);
		
		byte b[] = new byte[4096];
		
		// sFilePath 에 있는 파일의 MimeType 을 구해온다
		String sMimeType = context.getMimeType(sFilePath);
		System.out.println("sMimeType>>>" + sMimeType);
		
		if (sMimeType == null) {
			sMimeType = "application/octet-stream";
		}
		
		response.setContentType(sMimeType);
		
		// 파일 이름 깨지는 것을 방지
		String sEncoding = new String(fileName.getBytes("utf-8"), "ISO-8859-1");
		System.out.println(sEncoding);

		/*
		 *  Content-Disposition : attachment : 브라우저에서 다운로드하기 위해 사용한다.
		 */
		response.setHeader("content-Disposition", "attachment; filename=" + sEncoding);
		
		try ( 	// 웹 브라우저로의 출력 스트링 생성
			BufferedOutputStream out2 = new BufferedOutputStream(response.getOutputStream());
				
				// sFilePath 로 지정한 파일에 대한 입력 스트림 생성
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(sFilePath));) {
			
			int numRead;
			// read (b, 0, b.length) : 비이트 배열 b 의 0번 부터 b.length 크기 만큼 읽어온다.
			while ((numRead = in.read(b, 0, b.length)) != -1) { // 읽을 데이터 존재할 경우
				// 바이트 배열 b의 0번 부터 numRead 크기 만큼 브라우저로 출력
				out2.write(b, 0, numRead);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다." + fnfe);
		} catch (IOException ie) {
			ie.printStackTrace();
			System.out.println("파일 전송 실패" + ie);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
