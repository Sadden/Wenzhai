package sadden.wenzhai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

public class WeixinSignatureIdendtified extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();

		if (checkSignature(signature, timestamp, nonce)) {
			out.print(echostr); // 校验通过，原样返回echostr参数内容
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	public boolean checkSignature(String signature, String timestamp, String nonce) {
		String[] arr = new String[] { "weixin", timestamp, nonce };
		// 排序
		Arrays.sort(arr);
		// 生成字符串
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		// sha1加密
		String temp = getSHA1String(content.toString());
		return temp.equals(signature); // 与微信传递过来的签名进行比较
	}

	public String getSHA1String(String data) {
		return DigestUtils.sha1Hex(data); // 使用commons codec生成sha1字符串
	}

}
