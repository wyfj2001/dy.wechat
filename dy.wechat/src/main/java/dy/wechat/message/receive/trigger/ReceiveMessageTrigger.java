package dy.wechat.message.receive.trigger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class ReceiveMessageTrigger {

	private Map<Object, Object> conditions = new HashMap<Object, Object>();

	public Map<Object, Object> getConditions() {
		return conditions;
	}

	public Object put(Object key, Object value) {
		return conditions.put(key, value);
	}

	public void remove(Object key) {
		conditions.remove(key);
	}
	
	@Override
	public String toString() {
		return "trigger:" + String.valueOf(conditions);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conditions == null) ? 0 : conditions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceiveMessageTrigger other = (ReceiveMessageTrigger) obj;

		return Objects.equals(conditions, other.conditions);
	}
}
