package raoul2000.play.helloboot;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import raoul2000.play.helloboot.controller.HelloController;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
class HelloBootApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void when_requestHello_success() throws Exception {
		this.mockMvc.perform(get("/hello")
			.contentType(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk())
		.andExpect(content()
			.contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
		.andExpect(content().string("world"));
	}

}
