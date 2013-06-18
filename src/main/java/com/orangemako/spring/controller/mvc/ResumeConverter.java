package com.orangemako.spring.controller.mvc;

import com.itextpdf.text.DocumentException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/**
 * Resume/CV controller.
 *
 * @author Kevin Leong
 */
@Controller
@RequestMapping
public class ResumeConverter {

    @Resource(name = "resumeURI")
    String resumeUri;

    @Resource(name = "resumeContentDivId")
    String resumeContentDivId;

    @RequestMapping(value = "resume", method = RequestMethod.GET)
    public void getResumeAsPdfDocument(HttpServletResponse response, OutputStream outputStream)
            throws IOException, DocumentException {

        // Set response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachement;filename=kevin_leong_resume.pdf");

        // Retrieve Resume content and parse HTML
        org.jsoup.nodes.Document doc = Jsoup.parse((new URL(resumeUri)).openStream(), "UTF-8", resumeUri);
        Elements elements = doc.select(resumeContentDivId);

        Element contentDiv = elements.first();
        Elements contents = contentDiv.children();

        // Remove the table of contents
        contents.remove(0);

        StringBuilder resumeHtmlContent = new StringBuilder("<div>");
        for (Element e : contents) {
            resumeHtmlContent.append(e.outerHtml());
        }
        resumeHtmlContent.append("</div>");

        // Convert to PDF
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(resumeHtmlContent.toString());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
    }
}
