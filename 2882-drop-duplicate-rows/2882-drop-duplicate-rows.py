import pandas as pd

def dropDuplicateEmails(customers: pd.DataFrame) -> pd.DataFrame:
    return customers.sort_values('customer_id').drop_duplicates(subset='email', keep='first').sort_index()