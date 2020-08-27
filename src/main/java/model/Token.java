package model;

import org.joda.time.DateTime;

import java.util.UUID;

public class Token {

	private UUID id;
	private DateTime expireDate;
	private User user;

	public Token(UUID id, DateTime expireDate, User user) {
		this.id = id;
		this.expireDate = expireDate;
		this.user = user;
	}

	public Token(UUID id, DateTime expireDate) {
		this.id = id;
		this.expireDate = expireDate;
	}

	public Token() {

	}

	public Token(UUID randomUUID) {
		this.id = randomUUID;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public DateTime getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(DateTime expireDate) {
		this.expireDate = expireDate;
	}
	public boolean isExpired(){
		return DateTime.now().isAfter(expireDate);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this.getClass() != obj.getClass())
			return false;
		return this.id.equals(((Token)obj).id);
	}

	@Override
	public String toString() {
		return "Token{" +
				"id=" + id +
				", expireDate=" + expireDate +
				'}';
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
