package com.zakaprov.braincodemobihackathon.model.steam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SteamOwnedGames
{
    public class Response {
        @SerializedName("game_count")
        @Expose
        private Integer gameCount;
        @Expose
        private List<SteamGame> games = new ArrayList<SteamGame>();

        /**
         *
         * @return
         * The gameCount
         */
        public Integer getGameCount() {
            return gameCount;
        }

        /**
         *
         * @param gameCount
         * The game_count
         */
        public void setGameCount(Integer gameCount) {
            this.gameCount = gameCount;
        }

        /**
         *
         * @return
         * The games
         */
        public List<SteamGame> getGames() {
            return games;
        }

        /**s
         *
         * @param games
         * The games
         */
        public void setGames(List<SteamGame> games) {
            this.games = games;
        }
    }

    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
