/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/domain/FileDownload.e.vm.java
 */
package com.jaxio.web.domain;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import javax.inject.Named;
import javax.inject.Singleton;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import com.jaxio.domain.Document;
import com.jaxio.repository.DocumentRepository;

/**
 * Stateless controller to download {@link Document} binaries 
 */
@Named
@Singleton
public class DocumentFileDownload {
    @Inject
    private DocumentRepository documentRepository;

    /**
     * Primefaces support for documentBinary file download, this method is transactional so the binary can be lazily loaded
     */
    @Transactional(readOnly = true)
    public StreamedContent getDocumentBinaryStream(Document detachedDocument) {
        Document document = documentRepository.get(detachedDocument);
        return new DefaultStreamedContent( //
                new ByteArrayInputStream(document.getDocumentBinary()), //
                document.getDocumentContentType(), document.getDocumentFileName());
    }
}