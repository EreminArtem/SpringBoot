package ru.eremin.soap.note;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-01-24T00:29:03.687+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://eremin.ru/springboot/lessons/soap/note", name = "NoteEndpointPort")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface NoteEndpointPort {

    @WebMethod
    @WebResult(name = "findAllResponse", targetNamespace = "http://eremin.ru/springboot/lessons/soap/note", partName = "findAllResponse")
    public FindAllResponse findAll(
            @WebParam(partName = "findAllRequest", name = "findAllRequest", targetNamespace = "http://eremin.ru/springboot/lessons/soap/note")
                    FindAllRequest findAllRequest
    );

    @WebMethod
    @Oneway
    public void create(
            @WebParam(partName = "createRequest", name = "createRequest", targetNamespace = "http://eremin.ru/springboot/lessons/soap/note")
                    CreateRequest createRequest
    );

    @WebMethod
    @WebResult(name = "findNoteResponse", targetNamespace = "http://eremin.ru/springboot/lessons/soap/note", partName = "findNoteResponse")
    public FindNoteResponse findNote(
            @WebParam(partName = "findNoteRequest", name = "findNoteRequest", targetNamespace = "http://eremin.ru/springboot/lessons/soap/note")
                    FindNoteRequest findNoteRequest
    );
}
