package com.revnride.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.dom4j.DocumentException;
 

public interface PdfResume {
    
    InputStream generatePdf(Long id) throws IOException, DocumentException;
}
