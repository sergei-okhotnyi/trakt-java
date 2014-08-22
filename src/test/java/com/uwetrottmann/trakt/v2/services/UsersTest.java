package com.uwetrottmann.trakt.v2.services;

import com.uwetrottmann.trakt.v2.BaseTestCase;
import com.uwetrottmann.trakt.v2.TestData;
import com.uwetrottmann.trakt.v2.entities.User;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class UsersTest extends BaseTestCase {

    @Test
    public void test_profile() {
        User user = getTrakt().users().profile(TestData.USERNAME);
        assertThat(user.username).isEqualTo(TestData.USERNAME);
        assertThat(user.isPrivate).isEqualTo(false);
        assertThat(user.name).isEqualTo(TestData.USER_NAME);
        assertThat(user.vip).isEqualTo(true);
    }
}