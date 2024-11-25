package cesar.school.raycharge.presentation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BackendMapper extends ModelMapper {
    BackendMapper() {
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        return source != null ? super.map(source, destinationType) : null;
    }
}
