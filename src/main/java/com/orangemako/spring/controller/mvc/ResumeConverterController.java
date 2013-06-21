package com.orangemako.spring.controller.mvc;

import com.itextpdf.text.DocumentException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Resume/CV controller.
 *
 * @author Kevin Leong
 */
@Controller
@RequestMapping
public class ResumeConverterController {

    @Value("${resume.uri}")
    String resumeUri;

    @Value("${resume.content.div.id}")
    String resumeContentDivId;

    @Value("${resume.pdf.filename}")
    String pdfFilename;

    @Value("${resume.font.size.percent}")
    String resumeFontSizePercent;

    @Value("${resume.header.html}")
    String resumeHeaderHtml;

    @RequestMapping(value = "resume", method = RequestMethod.GET)
    public void getResumeAsPdfDocument(HttpServletResponse response, OutputStream outputStream)
            throws IOException, DocumentException {

        // Set response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachement;filename=" + pdfFilename);

        // Retrieve Resume content and parse HTML
        org.jsoup.nodes.Document doc = Jsoup.parse((new URL(resumeUri)).openStream(), "UTF-8", resumeUri);
        Elements elements = doc.select(resumeContentDivId);

        Element contentDiv = elements.first();
        Elements contents = contentDiv.children();

        // Remove the table of contents
        contents.remove(0);

        Date date = new Date();
        String dateString = String.format("%tB %<te, %<tY", date);

        // Wrap the content in a root tag (for SAX parser)
        StringBuilder resumeHtmlContent = new StringBuilder();
        resumeHtmlContent.append("<div style=\"font-size:")
                         .append(getResumeFontSizePercent()).append("%\">")
                         .append(resumeHeaderHtml)
                         .append("<p>This document is current as of ").append(dateString).append(".</p>");

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

    /**
     * Checks the system properties to see if a font size percentage has been set.  If not, use the default font
     * size setting.
     *
     * @return
     */
    String getResumeFontSizePercent() {
        String rval = System.getProperty("resumeFontSizePercent");

        rval = (rval != null) ? rval : resumeFontSizePercent;

        return rval;
    }
}
