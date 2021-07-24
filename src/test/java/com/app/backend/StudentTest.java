package com.app.backend;

import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void studentClassChecker() throws Exception{
        Student st = new Student("goutham","react","qwerty@");
        assert(st.emailCheck().equals(true));

    }
}
