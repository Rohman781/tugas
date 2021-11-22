package zul.android.chat.model;

public class ChatModel {

	String chatWith;
	String lastSentence;
	String date;

	public ChatModel() {
	}

	public String getChatWith() {
		return chatWith;
	}

	public void setChatWith(String chatWith) {
		this.chatWith = chatWith;
	}

	public String getLastSentence() {
		return lastSentence;
	}

	public void setLastSentence(String lastSentence) {
		this.lastSentence = lastSentence;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
