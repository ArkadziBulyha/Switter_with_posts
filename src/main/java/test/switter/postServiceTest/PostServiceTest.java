package test.switter.postServiceTest;

import com.switter.entity.Post;
import com.switter.service.PostService;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;

public class PostServiceTest {

    @Test
    public void addPostTest(){
        PostService postService = new PostService();
        Post post = new Post();
        postService.addPost(post);
        assertNotNull("addPostTest failed", post);
    }

    @Test
    public void editPostTest(){
        PostService postService = new PostService();
        int idPost = 0;
        String text = "";
        String login = "";
        postService.editPost(idPost, text, login);
        assertNotNull("editPostTest failed", idPost);
    }

}
