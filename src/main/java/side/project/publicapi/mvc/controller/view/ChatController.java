
@Controller
public class ChatController {
	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat/Chat");
		return mv;
	}
}