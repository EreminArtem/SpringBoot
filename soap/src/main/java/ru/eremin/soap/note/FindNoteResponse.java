
package ru.eremin.soap.note;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="note" type="{http://eremin.ru/springboot/lessons/soap/note}noteRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "note"
})
@XmlRootElement(name = "findNoteResponse")
public class FindNoteResponse {

    @XmlElement(required = true)
    protected NoteRecord note;

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link NoteRecord }
     *     
     */
    public NoteRecord getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoteRecord }
     *     
     */
    public void setNote(NoteRecord value) {
        this.note = value;
    }

}
