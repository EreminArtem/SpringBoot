
package ru.eremin.soap.note;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.eremin.springboot.lessons.soap.note package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.eremin.springboot.lessons.soap.note
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindNoteRequest }
     * 
     */
    public FindNoteRequest createFindNoteRequest() {
        return new FindNoteRequest();
    }

    /**
     * Create an instance of {@link FindNoteResponse }
     * 
     */
    public FindNoteResponse createFindNoteResponse() {
        return new FindNoteResponse();
    }

    /**
     * Create an instance of {@link NoteRecord }
     * 
     */
    public NoteRecord createNoteRecord() {
        return new NoteRecord();
    }

    /**
     * Create an instance of {@link FindAllRequest }
     * 
     */
    public FindAllRequest createFindAllRequest() {
        return new FindAllRequest();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link CreateRequest }
     * 
     */
    public CreateRequest createCreateRequest() {
        return new CreateRequest();
    }

}
