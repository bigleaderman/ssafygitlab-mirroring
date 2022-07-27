import styled from 'styled-components';


const Container = styled.section`
  overflow: hidden;
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
  align-items: center;
  height: 90vh;
`

const Button = styled.button`
  border: solid 2px var(--color-2);
  color: var(--color-2);
  background-color: var(--color-5);
  padding: 4px 10px;
  border-radius: 6px;
  font-size: 16px;
  margin-left: 10px;
  cursor: pointer;
`

const styleModal = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

export { Container, Button, styleModal };
