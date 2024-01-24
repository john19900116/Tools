package _Tools.parser.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Topic {
	@XmlElement(name = "Exchange")
	private String exchange;
	@XmlElement(name = "ComID")
	private String comID;
	@XmlElement(name = "DDSCExchange")
	private String dDSCExchange;
	@XmlElement(name = "DDSCComID")
	private String dDSCComID;
	@XmlElement(name = "ComType")
	private String comType;
	@XmlElement(name = "Denominator")
	private String denominator;
	@XmlElement(name = "Numerator")
	private String numerator;
	@XmlElement(name = "ComCName")
	private String comCName;

	public String getExchange() {
		return exchange;
	}

	public String getComID() {
		return comID;
	}

	public String getdDSCExchange() {
		return dDSCExchange;
	}

	public String getdDSCComID() {
		return dDSCComID;
	}

	public String getComType() {
		return comType;
	}

	public String getDenominator() {
		return denominator;
	}

	public String getNumerator() {
		return numerator;
	}

	public String getComCName() {
		return comCName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Topic [exchange=");
		builder.append(exchange);
		builder.append(", comID=");
		builder.append(comID);
		builder.append(", dDSCExchange=");
		builder.append(dDSCExchange);
		builder.append(", dDSCComID=");
		builder.append(dDSCComID);
		builder.append(", comType=");
		builder.append(comType);
		builder.append(", denominator=");
		builder.append(denominator);
		builder.append(", numerator=");
		builder.append(numerator);
		builder.append(", comCName=");
		builder.append(comCName);
		builder.append("]");
		return builder.toString();
	}

}
