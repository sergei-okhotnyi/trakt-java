package com.uwetrottmann.trakt.v2.services;

import com.uwetrottmann.trakt.v2.annotations.DELETE;
import com.uwetrottmann.trakt.v2.entities.CollectedMovie;
import com.uwetrottmann.trakt.v2.entities.CollectedShow;
import com.uwetrottmann.trakt.v2.entities.RatedEpisode;
import com.uwetrottmann.trakt.v2.entities.RatedMovie;
import com.uwetrottmann.trakt.v2.entities.RatedSeason;
import com.uwetrottmann.trakt.v2.entities.RatedShow;
import com.uwetrottmann.trakt.v2.entities.SyncItems;
import com.uwetrottmann.trakt.v2.entities.SyncRatedItems;
import com.uwetrottmann.trakt.v2.entities.SyncResponse;
import com.uwetrottmann.trakt.v2.entities.SyncWatchedItems;
import com.uwetrottmann.trakt.v2.entities.WatchedMovie;
import com.uwetrottmann.trakt.v2.entities.WatchedShow;
import com.uwetrottmann.trakt.v2.enums.RatingsFilter;
import retrofit.http.Body;
import retrofit.http.EncodedPath;
import retrofit.http.GET;
import retrofit.http.POST;

import java.util.List;

public interface Sync {

    /**
     * <b>OAuth Required</b>
     *
     * <p> Get all collected movies in a user's collection. A collected item indicates availability to watch digitally
     * or on physical media.
     */
    @GET("/sync/collection/movies")
    List<CollectedMovie> getCollectionMovies();

    /**
     * <b>OAuth Required</b>
     *
     * <p> Get all collected shows in a user's collection. A collected item indicates availability to watch digitally or
     * on physical media.
     */
    @GET("/sync/collection/shows")
    List<CollectedShow> getCollectionShows();

    /**
     * <b>OAuth Required</b>
     *
     * <p> Add one or more items to a user's collection including the format of the item.
     *
     * @param items A list of movies, shows, seasons or episodes.
     */
    @POST("/sync/collection")
    SyncResponse addItemsToCollection(
            @Body SyncItems items
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p> Remove one or more items from a user's collection.
     *
     * @param items A list of movies, shows, seasons or episodes.
     */
    @DELETE("/sync/collection")
    SyncResponse deleteItemsFromCollection(
            @Body SyncItems items
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p> Returns all movies a user has watched.
     */
    @GET("/sync/watched/movies")
    List<WatchedMovie> getWatchedMovies();

    /**
     * <b>OAuth Required</b>
     *
     * <p> Returns all shows a user has watched.
     */
    @GET("/sync/watched/shows")
    List<WatchedShow> getWatchedShows();

    /**
     * <b>OAuth Required</b>
     *
     * <p> Add items to a user's watch history. Accepts shows, seasons, episodes and movies. If only a show is passed,
     * assumes all seasons are to be marked watched. Same for seasons. Send a <code>watched_at</code> UTC datetime to
     * mark items as watched in the past. This is useful for syncing past watches from a media center.
     *
     * @param items A list of movies, shows, seasons or episodes.
     */
    @POST("/sync/history")
    SyncResponse addItemsToWatchedHistory(
            @Body SyncWatchedItems items
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p> Remove items from a user's watch history including all watches, scrobbles, and checkins. Accepts shows,
     * seasons, episodes and movies. If only a show is passed, assumes all seasons are to be removed from history. Same
     * for seasons.
     *
     * @param items A list of movies, shows, seasons or episodes.
     */
    @DELETE("/sync/history")
    SyncResponse deleteItemsFromWatchedHistory(
            @Body SyncItems items
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p> Get a user's ratings filtered by movies. You can filter for a specific rating between 1 and 10.
     *
     * @param filter Filter for a specific rating.
     */
    @GET("/sync/ratings/movies{rating}")
    List<RatedMovie> getRatingsMovies(
            @EncodedPath("rating") RatingsFilter filter
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p> Get a user's ratings filtered by shows. You can filter for a specific rating between 1 and 10.
     *
     * @param filter Filter for a specific rating.
     */
    @GET("/sync/ratings/shows{rating}")
    List<RatedShow> getRatingsShows(
            @EncodedPath("rating") RatingsFilter filter
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p> Get a user's ratings filtered by seasons. You can filter for a specific rating between 1 and 10.
     *
     * @param filter Filter for a specific rating.
     */
    @GET("/sync/ratings/seasons{rating}")
    List<RatedSeason> getRatingsSeasons(
            @EncodedPath("rating") RatingsFilter filter
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p> Get a user's ratings filtered by episodes. You can filter for a specific rating between 1 and 10.
     *
     * @param filter Filter for a specific rating.
     */
    @GET("/sync/ratings/episodes{rating}")
    List<RatedEpisode> getRatingsEpisodes(
            @EncodedPath("rating") RatingsFilter filter
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p> Rate one or more items.
     *
     * @param items A list of movies, shows, seasons or episodes.
     */
    @POST("/sync/ratings")
    SyncResponse addRatings(
            @Body SyncRatedItems items
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p> Delete ratings for one or more items.
     *
     * @param items A list of movies, shows, seasons or episodes.
     */
    @DELETE("/sync/ratings")
    SyncResponse deleteRatings(
            @Body SyncItems items
    );

}