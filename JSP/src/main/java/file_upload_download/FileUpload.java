package file_upload_download;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileUpload")
public class FileUpload extends HttpServlet{

	private static final long serialVersionUID = 6455866693959823975L;
	
	public FileUpload() {
		super();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadPath = request.getSession().getServletContext().getRealPath("upload");
		System.out.println("upload 경로 : " + uploadPath);
		// 지금 저장되는 경로는 이클립스에서 관리하는 경로. 
		// D:/HTA/HTA/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/JSP/upload
		
		int size = 10 * 1024 * 1024; // 파일 최대 크기를 10MB 로 지정한다.
		String name = "", subject = "", systemName1 = "", systemName2 = "",
				origfileName1 = "", origfileName2 = "";
		
		try {
			/*
				업로드를 담당하는 부분이다.
				
				1. 첫 번째 인자(request) : 폼에서 가져온 값을 얻기 위해 request 객체를 전달해 준다.
				2. 두 번째 인자(uploadPath) : 업로드될 파일의 위치이다.
				3. 세 번째 인자(size) : 업로드 할 크기이며 지정 크기보다 크면 Exception 발생한다.
				4. 네 번째 인자("UTF-8") : 파일 이름이 한글인 경우 처리하는 부분이다.
				5. 다섯 번째 인자 : 똑같은 파일을 업로드 할 경우 중복되지 않도록 자동으로 파일이름을 변환해주는 기능을 한다.
			 */
			MultipartRequest multi = new MultipartRequest(request,
															uploadPath, size, "UTF-8", 
																new DefaultFileRenamePolicy());
			name = multi.getParameter("name");
			subject = multi.getParameter("subject");
			
			// name = fileName1 의 input 에서 올린 파일의 시스템상의 파일명을 얻어온다.
			// 중복된 파일명의 경우 파일명 맨 뒤에 숫자를 붙여 처리한다.
			systemName1 = multi.getFilesystemName("fileName1");
			
			// name = fileName1의 input 에서 업로드한 원본 파일명을 얻어온다.
			origfileName1 = multi.getOriginalFileName("fileName1");
			
			systemName2 = multi.getFilesystemName("fileName2");
			origfileName2 = multi.getOriginalFileName("fileName2");
			
			request.setAttribute("name", name);
			request.setAttribute("subject", subject);
			request.setAttribute("systemName1", systemName1);
			request.setAttribute("systemName2", systemName2);
			request.setAttribute("origfileName1", origfileName1);
			request.setAttribute("origfileName2", origfileName2);
			request.setAttribute("uploadPath", uploadPath);
			request.getRequestDispatcher("/ex6_fileupload_download/_3.cos/ex/fileCheck.jsp")
			.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러 입니다.");
		}
	}
}
