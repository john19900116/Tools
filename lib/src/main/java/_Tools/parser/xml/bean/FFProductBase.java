package _Tools.parser.xml.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FFProductBase")
public class FFProductBase {
	@XmlElement(name = "Topic")
	List<Topic> topic;

	public List<Topic> getTopic() {
		return topic;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FFProductBase [topic=");
		builder.append(topic);
		builder.append("]");
		return builder.toString();
	}

}
