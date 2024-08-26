package com.dts.test;
import java.io.File;
import org.apache.tika.Tika;

public class FileCheckIdentify
{
	public static final boolean checkPaySlipBill(String fileData) 
	{
		return fileData.contains("Payslip") || 
								fileData.contains("Employee No") || 	
												fileData.contains("Total net payable");
	}
	public static final boolean checkAadharCard(String fileData) {
		return fileData.contains("Aadhaar") || 
							fileData.contains("UIDAI") || 
										fileData.contains("Government of India");
	}
	public static final boolean checkDrivinglicense(String fileData) {
		return fileData.contains("Driving License") || 
										fileData.contains("DL No") || 
													fileData.contains("License Number");
	}
	
	public static void getDisplayOutput(String content) 
	{
		if(checkPaySlipBill(content)) {
			System.out.println("The document is PaySlip.");
		}
		else if(checkAadharCard(content)) {
			System.out.println("The document is AadharCard.");
		}
		else if(checkDrivinglicense(content)) {
			System.out.println("The document is Driving License.");
		}
	}
	
	public static void main(String[] args) 
	{	
		try {
			Tika tika = new Tika();
			File file = new File("d:\\TCSPaySlip.pdf");
			String content = tika.parseToString(file);
			getDisplayOutput(content);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}	
	}
}