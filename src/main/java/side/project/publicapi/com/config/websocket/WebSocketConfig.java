
@Configuration
@EnableWebSocket// 웹소켓 활성화
public class WebSocketConfig implements WebSocketConfigurer{

    // Spring에서 웹소켓을 사용하기 위해서 클라이언트가 보내는 통신을 처리할 핸들러가 필요하다.
    // 위에서 작성한 DevLogWebSocketHandler를 Handshake할 주소와 함께 추가한다.
    // 주소는 PORT 뒤에 endpoint를 입력하면 된다.
    // ws://127.0.0.1:80/chating

	@Autowired
	private DevLogWebSocketHandler devLogWebSocketHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// WebSocketHandler를 추가
		registry.addHandler(devLogWebSocketHandler, "/chating");
	}
}