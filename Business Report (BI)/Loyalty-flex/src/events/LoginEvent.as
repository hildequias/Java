package events
{
	import flash.events.Event;
	
	import valueObjects.UserVO;
	
	public class LoginEvent extends Event
	{
		public static const LOGIN_OK:String = "LoginEvent.LOGIN_OK";
		
		public static const ON_POPUP_SAVE:String="ON_POPUP_SAVE";
		
		public static const ON_POPUP_REMOVE:String = "ON_POPUP_REMOVE";
		
		
		public var usuario:UserVO;
		
		public function LoginEvent(type:String,u:UserVO)
		{
			usuario = u;
			super(type, true);
		}
	}
}