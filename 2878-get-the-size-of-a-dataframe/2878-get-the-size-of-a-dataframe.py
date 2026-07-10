import pandas as pd

def getDataframeSize(employees: pd.DataFrame) -> List[int]:
    return list(employees.shape)
