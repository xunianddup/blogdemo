package com.xfire.it.blog.server.article.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping(value="/png.do",
			produces="image/png")
	@ResponseBody
	public byte[] demo() throws IOException{
		
		BufferedImage img=
			new BufferedImage(100, 30, 
			BufferedImage.TYPE_3BYTE_BGR);
		ByteArrayOutputStream out=
			new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		byte[] data = out.toByteArray();
		return data;
	}
	
	@RequestMapping(value="excel.do",
		produces="application/vnd.ms-excel")
	@ResponseBody
	public byte[] excel(
		HttpServletResponse response)
		throws IOException{
		
		response.setHeader(
			"Content-Disposition", 
			"attachment;filename=\"demo.xls\"");
		
		HSSFWorkbook book=new HSSFWorkbook();
		HSSFSheet sheet = book.createSheet(
				"出勤");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue("Hello World!");
		
		ByteArrayOutputStream out =
			new ByteArrayOutputStream();
		book.write(out);
		out.close();
		byte[] data = out.toByteArray();
		return data;
	}
}











