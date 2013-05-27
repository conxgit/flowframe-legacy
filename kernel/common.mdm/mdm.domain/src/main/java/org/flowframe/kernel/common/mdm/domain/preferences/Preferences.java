//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.03 at 01:46:20 PM EST 
//

package org.flowframe.kernel.common.mdm.domain.preferences;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.flowframe.kernel.common.mdm.domain.MultitenantBaseEntity;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

/**
 * <p>
 * Java class for preferences complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="preferences">
 *   &lt;complexContent>
 *     &lt;extension base="{http://flowframe.org/kernel/common/mdm/domain}MultitenantBaseEntity">
 *       &lt;sequence>
 *         &lt;element ref="{http://flowframe.org/kernel/common/mdm/domain/preferences}prefroot"/>
 *       &lt;/sequence>
 *       &lt;attribute name="EXTERNAL_XML_VERSION" type="{http://www.w3.org/2001/XMLSchema}string" default="0.0" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preferences", propOrder = { "prefroot" })
@Entity(name = "Preferences")
@Table(name = "ffpreferences")
public class Preferences extends MultitenantBaseEntity implements Equals, HashCode, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7869822230680505559L;
	@XmlElement(required = true)
	@ManyToOne(targetEntity = Prefroot.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PREFROOT_PREFERENCES_HJID")
	protected Prefroot prefroot;
	@XmlAttribute(name = "EXTERNAL_XML_VERSION")
	protected String externalxmlversion;

	/**
	 * Gets the value of the prefroot property.
	 * 
	 * @return possible object is {@link Prefroot }
	 * 
	 */
	public Prefroot getPrefroot() {
		return prefroot;
	}

	/**
	 * Sets the value of the prefroot property.
	 * 
	 * @param value
	 *            allowed object is {@link Prefroot }
	 * 
	 */
	public void setPrefroot(Prefroot value) {
		this.prefroot = value;
	}

	/**
	 * Gets the value of the externalxmlversion property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	@Basic
	@Column(name = "EXTERNALXMLVERSION", length = 255)
	public String getEXTERNALXMLVERSION() {
		if (externalxmlversion == null) {
			return "0.0";
		} else {
			return externalxmlversion;
		}
	}

	/**
	 * Sets the value of the externalxmlversion property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEXTERNALXMLVERSION(String value) {
		this.externalxmlversion = value;
	}

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
		if (!(object instanceof Preferences)) {
			return false;
		}
		if (this == object) {
			return true;
		}
		if (!super.equals(thisLocator, thatLocator, object, strategy)) {
			return false;
		}
		final Preferences that = ((Preferences) object);
		{
			Prefroot lhsPrefroot;
			lhsPrefroot = this.getPrefroot();
			Prefroot rhsPrefroot;
			rhsPrefroot = that.getPrefroot();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "prefroot", lhsPrefroot), LocatorUtils.property(thatLocator, "prefroot", rhsPrefroot), lhsPrefroot, rhsPrefroot)) {
				return false;
			}
		}
		{
			String lhsEXTERNALXMLVERSION;
			lhsEXTERNALXMLVERSION = this.getEXTERNALXMLVERSION();
			String rhsEXTERNALXMLVERSION;
			rhsEXTERNALXMLVERSION = that.getEXTERNALXMLVERSION();
			if (!strategy.equals(LocatorUtils.property(thisLocator, "externalxmlversion", lhsEXTERNALXMLVERSION), LocatorUtils.property(thatLocator, "externalxmlversion", rhsEXTERNALXMLVERSION),
					lhsEXTERNALXMLVERSION, rhsEXTERNALXMLVERSION)) {
				return false;
			}
		}
		return true;
	}

	public boolean equals(Object object) {
		final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
		return equals(null, null, object, strategy);
	}

	public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
		int currentHashCode = super.hashCode(locator, strategy);
		{
			Prefroot thePrefroot;
			thePrefroot = this.getPrefroot();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "prefroot", thePrefroot), currentHashCode, thePrefroot);
		}
		{
			String theEXTERNALXMLVERSION;
			theEXTERNALXMLVERSION = this.getEXTERNALXMLVERSION();
			currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "externalxmlversion", theEXTERNALXMLVERSION), currentHashCode, theEXTERNALXMLVERSION);
		}
		return currentHashCode;
	}

	public int hashCode() {
		final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
		return this.hashCode(null, strategy);
	}

}