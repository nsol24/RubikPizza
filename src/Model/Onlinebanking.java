package Model;

import java.io.InputStream;
import java.sql.Blob;

public class Onlinebanking extends Payment {
	
	private String base64Image;
	InputStream receiptImage;
	private String obstatus;
	
	private String cardNumber;
	private String expiryMonth;
	private String expiryYear;
	private String cvv;
	
	public String getObstatus() {
		return obstatus;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public void setObstatus(String obstatus) {
		this.obstatus = obstatus;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public InputStream getReceiptImage() {
		return receiptImage;
	}

	public void setReceiptImage(InputStream receiptImage) {
		this.receiptImage = receiptImage;
	}
	
	
	
	
}
