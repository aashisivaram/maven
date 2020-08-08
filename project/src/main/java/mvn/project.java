package mvn;

import micronet.annotation.MessageListener;
import micronet.annotation.MessageService;
import micronet.annotation.OnStart;
import micronet.network.Context;
import micronet.network.Request;

@MessageService(uri = "mn://project")
public class project {
	
	@OnStart
	public void onStart(Context context) {
		System.out.println("project Start Routine...");
		context.sendRequest("mn://project/hello/world/handler", new Request("Hello"));
	}
	
	@MessageListener(uri="/hello/world/handler")
	public void helloHandler(Context context, Request request) {
		System.out.println(request.getData() + " World MicroNet...");
	}
}

