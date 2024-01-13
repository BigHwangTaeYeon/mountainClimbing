# Security

2024-01-13</br>
처음 만들었을 때,</br>
user 객체를 만들고 UserDetails 인터페이스를 상속받기만 하면 된다고 생각했다.</br>
그것이 아닌, MemberDetails class를 만들고 클라이언트 정보를 user에 담아 MemberDetails로 넘겨주는 것이 필요했다.

```java
public UserDetails loadUserByUsername(String username) {
    User user = new User();
    try {
        user = LoginVODao.selectUserById(username);
        String password = passwordEncoder.encode(user.getPw());
        user.setPw(password);
        user.setRole("ROLE_USER");
    } catch (Exception e) {
        throw new RuntimeException(e);
    } finally {
        if (user != null) {
            return new MemberDetails(user);
        }
    }
    return null;
}
```
클라이언트 정보를 MemberDetails에 넘겨줌으로 써, UserDetails 객체를 만들어 줘야 했던 것이다.

그리고 패스워드 암호화를 하라는 메시지가 나왔고,
권한을 부여해주어야 한다는 메시지도 나왔다.</br>
(암호화든 권한이든 일단 기능 작동부터 하자는 생각이었다)

이렇게 모든 정보가 있어야 Spring Security의 기능을 사용할 수 있다.