package com.example.qrcode.utils;

import com.example.qrcode.model.Student;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


// Скачать пустую qrcode и заново делать
public class QRCodeGenerator {

    public static void generatorQRcode(Student student) throws WriterException, IOException {
        String qrCodePath = "C:\\Users\\user\\IdeaProjects\\QRCode\\";
        String qrCodeName = qrCodePath + student.getFirstname() + student.getId() + "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: " + student.getId() + "\n" +
                "Firstname:" + student.getFirstname()+ "\n" +
                "Lastname:" + student.getLastname() + "\n" +
                "Email:" + student.getEmail() + "\n" +
                "Mobile:" + student.getMobile(), BarcodeFormat.QR_CODE, 400,400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }
}
