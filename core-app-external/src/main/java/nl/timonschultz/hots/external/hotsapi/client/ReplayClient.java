package nl.timonschultz.hots.external.hotsapi.client;

import nl.timonschultz.hots.external.hotsapi.exception.ClientException;

import java.util.List;

public interface ReplayClient {

    List<Object> getReplaysFromApi(String queryString) throws ClientException;

    List<Object> getReplaysPagedFromApi(String queryString) throws ClientException;

    Object getReplayFromApi(Long replayId) throws ClientException;

}