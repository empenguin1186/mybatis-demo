package jp.co.penguin.mybatisdemo.application.service.security

import jp.co.penguin.mybatisdemo.application.service.AuthenticationService
import jp.co.penguin.mybatisdemo.domain.enum.RoleType
import jp.co.penguin.mybatisdemo.domain.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class BookManagerUserDetailService(
    private val authenticationService: AuthenticationService
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {
        val user = authenticationService.findUser(username)
        return user?.let { BookManagerUserDetails(it) }
    }
}

data class BookManagerUserDetails private constructor(
    val id: Long,
    val email: String,
    val pass: String,
    val roleType: RoleType
) : UserDetails {

    constructor(user: User) : this(user.id, user.email, user.password, user.roleType)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(this.roleType.toString())
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.pass
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}