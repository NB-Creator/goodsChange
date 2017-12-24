package security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import po.MyUser;

public class MyUserDetail implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5619502406659516775L;
	private MyUser myUser;
	private Collection<? extends GrantedAuthority> authorities;

	public MyUserDetail(MyUser user,Collection<? extends GrantedAuthority> authorities) {
		this.myUser = user;
		this.authorities = authorities;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	public MyUser getMyUser() {
		return myUser;
	}
	public String getPassword() {
		return myUser.getPassword();
	}

	public String getUsername() {
		return myUser.getUsername();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
