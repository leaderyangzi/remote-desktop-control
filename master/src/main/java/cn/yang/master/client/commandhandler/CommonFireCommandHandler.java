package cn.yang.master.client.commandhandler;

import cn.yang.common.command.Commands;
import cn.yang.common.dto.Request;
import cn.yang.common.exception.CommandHandlerException;
import cn.yang.master.client.constant.ExceptionMessageConstants;
import cn.yang.master.client.exception.ConnectionException;
import cn.yang.master.client.exception.FireCommandHandlerException;

/**
 * @author Cool-Coding
 *         2018/7/27
 */
public class CommonFireCommandHandler extends AbstractMasterFireCommandHandler<Object> {

    @Override
    public void fire(String puppetName,Enum<Commands> command,Object data) throws FireCommandHandlerException {
        if (puppetName==null){
            throw new FireCommandHandlerException(ExceptionMessageConstants.PUPPET_NAME_EMPTY);
        }

        final Request request = buildRequest(command, puppetName, data);
        try {
            sendRequest(request);
        }catch (ConnectionException e){
            throw  new FireCommandHandlerException(e);
        }
    }
}
